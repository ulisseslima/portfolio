package com.dvlcube.servlet;

import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * @author wonka
 * @since 09/08/2012
 */
public class OptionProcessor extends AbstractProcessor {

	private String className;

	private void generateOptionProcessor(final Filer filer, final HashMap<String, String> values)
			throws Exception {

		final String generatedClassName = className + "Processor";

		final JavaFileObject source = filer.createSourceFile(generatedClassName);
		final Writer writer = source.openWriter();

		writer.write("/* Generated on " + new Date() + " */\n");
		writer.write("public class " + generatedClassName + " {\n");
		writer.write("\tpublic static " + className + " process(String[] args) {\n");
		writer.write("\t\t" + className + " options = new " + className + "();\n");
		writer.write("\t\tint idx = 0;\n");
		writer.write("\t\twhile (idx < args.length) {\n");

		for (final String key : values.keySet()) {
			writer.write("\t\t\tif (args[idx].equals(\"" + key + "\")) {\n");
			writer.write("\t\t\t\toptions." + values.get(key) + " = args[++idx];\n");
			writer.write("\t\t\t\tidx++;\n");
			writer.write("\t\t\t\tcontinue;\n");
			writer.write("\t\t\t}\n");
		}

		writer.write("\t\t\tSystem.err.println(\"Unknown option: \" + args[idx++]);\n");
		writer.write("\t\t}\n");
		writer.write("\t\treturn (options);\n");
		writer.write("\t}\n");
		writer.write("}");
		writer.flush();
		writer.close();
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		final Set<String> types = new HashSet<String>();
		types.add(Option.class.getName());
		return types;
	}

	@Override
	public boolean process(final Set<? extends TypeElement> elements, final RoundEnvironment env) {
		// processingEnv is a predefined member in AbstractProcessor class
		// Messager allows the processor to output messages to the environment
		final Messager messager = processingEnv.getMessager();

		// Create a hash table to hold the option switch to option bean mapping
		final HashMap<String, String> values = new HashMap<String, String>();

		// Loop through the annotations that we are going to process
		// In this case there should only be one: Option
		for (final TypeElement te : elements) {

			// Get the members that are annotated with Option
			for (final Element e : env.getElementsAnnotatedWith(te)) {
				// Process the members. processAnnotation is our own method
				processAnnotation(e, values, messager);
			}
		}

		// If there are any annotations, we will proceed to generate the annotation
		// processor in generateOptionProcessor method
		if (values.size() > 0) {
			try {
				// Generate the option process class
				generateOptionProcessor(processingEnv.getFiler(), values);
			} catch (final Exception e) {
				messager.printMessage(Diagnostic.Kind.ERROR, e.getMessage());
			}
		}
		return true;
	}

	private void processAnnotation(
		final Element element,
		final HashMap<String, String> values,
		final Messager msg) {

		// Get the Option annotation on the member
		final Option option = element.getAnnotation(Option.class);

		// Get the class name of the option bean
		className = element.getEnclosingElement().toString();

		// Check if the type in the member is a String. If not we ignore it
		// We are currently only supporting String type
		if (!element.asType().toString().equals(String.class.getName())) {
			msg.printMessage(Diagnostic.Kind.WARNING, element.asType() + " not supported. " + option.name()
					+ " not processed");
			return;
		}

		// Save the option switch and the member's name in a hash set
		// e.g. -filename (option switch) mapped to fileName (member)
		values.put(option.name(), element.getSimpleName().toString());
	}
}

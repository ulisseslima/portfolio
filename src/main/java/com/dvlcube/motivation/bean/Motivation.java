package com.dvlcube.motivation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dvlcube.reflection.FieldName;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
@Entity
public class Motivation implements Identifiable {
	public enum Field implements FieldName {
		dislikes, id, imageUrl, likes, shares, subtitle, title, views
	}

	private static final long serialVersionUID = -8908958239448876341L;

	private long dislikes;

	@Id
	@GeneratedValue
	private Long id;

	private String imageUrl;

	private long likes;

	private long shares;

	private String subtitle;

	private String title;

	private long views;

	/**
	 * @return the dislikes
	 */
	public long getDislikes() {
		return dislikes;
	}

	/**
	 * @return the id
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public String getLabel() {
		return toString();
	}

	/**
	 * @return the likes
	 */
	public long getLikes() {
		return likes;
	}

	/**
	 * @return the shares
	 */
	public long getShares() {
		return shares;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the views
	 */
	public long getViews() {
		return views;
	}

	/**
	 * @param dislikes
	 *            the dislikes to set
	 */
	public void setDislikes(final long dislikes) {
		this.dislikes = dislikes;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(final String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	public void setLikes(final long likes) {
		this.likes = likes;
	}

	/**
	 * @param shares
	 *            the shares to set
	 */
	public void setShares(final long shares) {
		this.shares = shares;
	}

	/**
	 * @param subtitle
	 *            the subtitle to set
	 */
	public void setSubtitle(final String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * @param views
	 *            the views to set
	 */
	public void setViews(final long views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Motivation [title=" + title + ", subtitle=" + subtitle + ", likes=" + likes + ", dislikes="
				+ dislikes + ", shares=" + shares + ", views=" + views + "]";
	}
}

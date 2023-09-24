package com.jotd.types;

import java.sql.Date;
import java.util.HashMap;

import org.json.JSONObject;

public class Joke {

  private long id;
  private Date day;
  private String text;
  private String desc;

  private Joke() {
  }

  public Joke(Date day, String text, String desc) {
    this();
    this.day = day;
    this.text = text;
    this.desc = desc;
  }

  public Joke(long id, Date day, String text, String desc) {
    this(day, text, desc);
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getDay() {
    return day;
  }

  public void setDay(Date day) {
    this.day = day;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public boolean equals(Object o) {
    if (!(o instanceof Joke)) {
      return false;
    }

    Joke other = (Joke) o;

    if (this.id != other.id) {
      return false;
    } else if (!this.day.equals(other.day)) {
      return false;
    } else if (!this.text.equals(other.text)) {
      return false;
    } else if (this.desc == null) {
      return other.desc == null;
    } else if (other.desc == null) {
      return false;
    }
    return this.desc.equals(other.desc);
  }

  public String toString() {
    return toJSONString();
  }

  public String toJSONString() {
    return JSONObject.valueToString(new HashMap<String, Object>() {
      {
        put("id", id);
        put("day", day);
        put("text", text);
        put("description", desc);
      }
    });
  }
}

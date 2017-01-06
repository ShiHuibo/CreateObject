package com.study.createObject;

import java.io.Serializable;

/**
 * create object in several ways
 *
 * @author shihuibo
 * @version 1.0
 * @since 2017/01/05 20:06.
 */
public class CreateObject implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String object;

    public CreateObject() {
        this.name = "";
        this.object = "Object";
    }

    public CreateObject(String name, String object) {
        this.name = name;
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode()) + ((object == null) ? 0 : object.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        CreateObject co = (CreateObject) obj;
        if (this.name == null) {
            if (co.name != null)
                return false;
        } else if (!this.name.equals(co.name))
            return false;
        if (this.object == null) {
            if (co.object != null)
                return false;
        } else if (!this.object.equals(co.object))
            return false;
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public String toString() {
        return "CreateObject [name=" + this.name + ",object=" + this.object + "]";
    }

}

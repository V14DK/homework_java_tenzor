package com.company;

public class File extends AbstractFileSystemNode {
    private String extention;

    File(String name, String extention){
        this.name = name;
        this.extention = extention;
        this.path = "main/" + this.toString();
    }

    File(Folder parent, String name, String extention) {
        this.parent = parent;
        this.name = name;
        this.extention = extention;
        this.path = this.parent.GetPath() + this.toString();
    }

    public void SetExt(String extention){ this.extention = extention; }

    public String GetExt(){ return this.extention; }

//    @Override
//    public String Get

    @Override
    public String GetName(){ return this.name; }

    public String toString(){ return this.name + '.' + this.extention; }
}

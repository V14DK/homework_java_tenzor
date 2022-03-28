package com.company;

import java.util.ArrayList;

public class Folder extends AbstractFileSystemNode{
    private ArrayList<AbstractFileSystemNode> children = new ArrayList<>();

    Folder(Folder parent, String name){
        this.parent = parent;
        this.name = name;
        if (this.parent != null) {
            parent.AddFolder(this);
            this.path = parent.path.concat('/' + this.name);
        } else {
            this.path = "main";
        }
    }

    public void AddFolder(AbstractFileSystemNode folder){ this.children.add(folder); }

    public void AddFile(AbstractFileSystemNode file){
        this.children.add(file);
        file.SetParent(this);
    }

    public ArrayList<AbstractFileSystemNode> GetChildren(){
        return this.children;
    }


}

package com.company;

public class AbstractFileSystemNode implements FileSystemNode{
    protected FileSystemNode parent = null;
    protected String name;
    protected String path;

    public final void SetParent(FileSystemNode parent) {
        this.parent = parent;
        this.path = this.parent.GetPath() + '/' + this.toString();
    }

    public final FileSystemNode GetParent() { return this.parent; }

    public String GetName() {return this.name; }

    public final String GetPath() {
        return this.path;
    }
}

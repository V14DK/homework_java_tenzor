package com.company;

public interface FileSystemNode {
    public void SetParent(FileSystemNode parent);

    public FileSystemNode GetParent();

    public String GetName();

    public String GetPath();
}

package edu.ntnu.idatt1002.k2_2.mitodo.data.project;


public class UserProject extends Project
{
    private String title;
    private final Project parent;

    public UserProject(String title, Project parent)
    {
        this.parent = parent;
        if(title.isEmpty() || title.isBlank())
        {
            throw new IllegalArgumentException("Title of projects can't be empty");
        }
        if(title.length() > MAX_TITLE_SIZE){
            throw new IllegalArgumentException("Project Name must be below " + MAX_TITLE_SIZE + ".");
        }
        if(projectAlreadyCreated(title))
        {
            throw new IllegalArgumentException("Project already created");
        }

        this.title = title.trim();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        if(title.isEmpty() || title.isBlank())
        {
            throw new IllegalArgumentException("Title of projects can't be empty");
        }
        if(title.length() > MAX_TITLE_SIZE){
            throw new IllegalArgumentException("Project Name must be below " + MAX_TITLE_SIZE + ".");
        }
        if(projectAlreadyCreated(title))
        {
            throw new IllegalArgumentException("Project already created");
        }
        this.title = title;
    }

    public boolean projectAlreadyCreated(String title)
    {
        if(parent == null || parent.getProjects().size() == 0)
        {
            return false;
        }
        return parent.getProjects().stream().anyMatch(p -> p.getTitle().equalsIgnoreCase(title));
    }

    public Project getParent()
    {
        return parent;
    }

    @Override
    public String toString()
    {
        return title;
    }
}
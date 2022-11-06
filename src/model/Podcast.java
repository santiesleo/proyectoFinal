package model;

public class Podcast extends Audio{
    private String description;
    private String icon;
    private Category category;

    public Podcast(String name, String duration, String description, String icon, int option) {
        super(name, duration);
        this.description = description;
        this.icon = icon;
        switch (option){
            case 1:
                category = Category.POLITICS;
                break;
            case 2:
                category = Category.ENTERTAINMENT;
                break;
            case 3:
                category = Category.VIDEOGAME;
                break;
            case 4:
                category = Category.FASHION;
                break;
        }
    }

    @Override
    public String toString() {
        return "Podcast{" +
                super.toString() +
                "description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", category=" + category +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

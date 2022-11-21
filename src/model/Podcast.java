package model;

/**
 * The podcast class
 */
public class Podcast extends Audio{
    private String description;
    private String icon;
    private Category category;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class podcast.<br>
     */
    public Podcast(String name, int duration, String description, String icon, int option) {
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

    /**
     *
     * @return The attributes of the user podcast
     */
    @Override
    public String toString() {
        return "Podcast{" +
                super.toString() +
                "description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", category=" + category +
                '}';
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description The description of the podcast
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon The icon of the podcast
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     *
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category The category of the podcast
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}

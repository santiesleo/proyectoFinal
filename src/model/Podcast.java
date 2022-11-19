package model;

/**
 *
 */
public class Podcast extends Audio{
    private String description;
    private String icon;
    private Category category;

    /**
     *
     * @param name
     * @param duration
     * @param description
     * @param icon
     * @param option
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
     * @return
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
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     *
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}

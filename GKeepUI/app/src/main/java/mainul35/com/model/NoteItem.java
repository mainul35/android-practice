package mainul35.com.model;

public class NoteItem {
    String itemTitle;
    String itemDescription;

    public NoteItem(String itemTitle, String itemDescription) {
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public String toString() {
        return "NoteItem{" +
                "itemTitle='" + itemTitle + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}

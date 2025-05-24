

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public int qtyOrdered = 0;

	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBER_ORDERED) {
			System.out.println("The cart is full.");
			return;
		}
		if (!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added to the cart.");
		} else {
			System.out.println(media.getTitle() + " is already in the cart.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " has been removed from the cart.");
		} else {
			System.out.println(media.getTitle() + " is not in the cart.");
		}
	}

	public float totalCost() {
		float total = 0;
		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		return Math.round(total * 100.0f) / 100.0f;
	}
	
    public void searchCart(String title) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Media with title \"" + title + "\" were not found.");
        }
    }

    public void searchCart(int id) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(id)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Media with id " + id + " were not found.");
        }
    }

    public Media search(int id) {
        for (Media item : itemsOrdered){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public Media search(String title) {
        for (Media item : itemsOrdered){
            if (item.isMatch(title)){
                return item;
            }
        }
        return null;
    }

    public ArrayList<Media> filterById(int id) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemsOrdered){
            if (item.getId() == id){
                media.add(item);
            }
        }
        return media;
    }

    public ArrayList<Media> filterByTitle(String title) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemsOrdered){
            if (item.isMatch(title)){
                media.add(item);
            }
        }
        return media;
    }

    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void playMedia(Media media) throws PlayerException {
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            dvd.play();
        }
        if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            cd.play();
        }
    }
    public void print(){
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            if (media != null) {
                System.out.println((i + 1) + ". " + media.getTitle() + " - " + media.getCost());
            } else {
                System.out.println((i + 1) + ". Null item");
            }
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************");
    }
}
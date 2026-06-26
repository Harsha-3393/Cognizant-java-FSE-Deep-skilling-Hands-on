import java.util.Arrays;
import java.util.Scanner;

public class BookSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book[] books = {
            new Book(1, "The Guide", "R. K. Narayan"),
            new Book(2, "Untouchable", "Mulk Raj Anand"),
            new Book(3, "The Story Of My Experiments With The Truth", "Mahatma Gandhi"),
            new Book(4, "A Fine Balance", "Rohinton Mistry")
        };

        System.out.print("Enter book title to search: ");
        String searchTitle = sc.nextLine();

        // Linear Search
        Book foundBookLinear = linearSearch(books, searchTitle);

        System.out.println("\nLinear Search Result:");
        if (foundBookLinear != null) {
            System.out.println(foundBookLinear);
        } else {
            System.out.println("Book Not Found");
        }

        // Sort array for Binary Search
        Arrays.sort(books,
                (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // Binary Search
        Book foundBookBinary = binarySearch(books, searchTitle);

        System.out.println("\nBinary Search Result:");
        if (foundBookBinary != null) {
            System.out.println(foundBookBinary);
        } else {
            System.out.println("Book Not Found");
        }

        sc.close();
    }

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int cmp = books[mid].getTitle()
                    .compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            }
            else if (cmp < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }
}
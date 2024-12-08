import java.util.ArrayList;
import java.util.List;

public class Pagination {
    List<Person> people = new ArrayList<>();
    int perPage = 2;

    public Pagination() {
        this.people.add(new Person("John", "Smith"));
        this.people.add(new Person("Jane", "Doe"));
        this.people.add(new Person("Bob", "Smith"));
        this.people.add(new Person("Alice", "Johnson"));
        this.people.add(new Person("Charlie", "Brown"));
    }

    public int getNoOfPages() {
        return (int) Math.ceil((double) people.size() / perPage);
    }

    public int getTotal() {
        return people.size();
    }

    public List<Person> getPage(int page) {
        if (page < 1 || page > getNoOfPages()) {
            throw new IllegalArgumentException("Invalid page number");
        }

        int start = (page - 1) * perPage;
        int end = Math.min(start + perPage, people.size());
        return people.subList(start, end);
    }

    public static void main(String[] args) {
        Pagination pagination = new Pagination();
        System.out.println(pagination.getNoOfPages());
        System.out.println(pagination.getTotal());
        System.out.println(pagination.getPage(1));
        System.out.println(pagination.getPage(2));
    }

}

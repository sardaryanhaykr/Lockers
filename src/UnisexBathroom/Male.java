package UnisexBathroom;

/**
 * Created by Hayk on 09.08.2021.
 */
public class Male extends Thread {
    private final String name;
    private Bathroom bathroom;

    public Male(Bathroom bathroom, String name) {
        this.name = name;
        this.bathroom = bathroom;
    }

    @Override
    public void run() {
        try {
            bathroom.add(this);
            System.out.println(this.name + " is bathe");
            sleep(1000);
            System.out.println(this.name + " finish to bathe");
            bathroom.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Male male = (Male) o;

        if (name != null ? !name.equals(male.name) : male.name != null) return false;
        return bathroom != null ? bathroom.equals(male.bathroom) : male.bathroom == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (bathroom != null ? bathroom.hashCode() : 0);
        return result;
    }
}

public class input1 {
    public static void main(String[] args) {
        int l = 5, w = 6, h = 7, volume, surf_area;
        volume = l*w*h;
        surf_area = 2*(l*w + l*h + h*w);
        System.out.println("The volume is " + volume + " and surface area is " + surf_area);
    }
}

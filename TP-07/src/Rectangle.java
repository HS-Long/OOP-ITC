public class Rectangle{
    int width;
    int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int calculatePerimeter(){
        return (width + height) * 2;
    }
    public int calculateSurface(){
        return width * height;
    }
}


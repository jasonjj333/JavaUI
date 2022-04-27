package ItemGeneratorTest;

public class LayoutManager {
    private int width; //panel width
    private int furthestWidth = 0; //x value of rightmost point used currently
    private int currentHeight = 0; //down-most y-point used in current columnspace
    private int currentWidth = 0;
    private int x = 0;
    private int y = 0;
    private int height; //panel height
    private int horizontalMarginSpace;
    private int verticalMarginSpace;
    private int customHMargin = -1;
    private int customVMargin = 0;

    public LayoutManager(int w, int h) {
        new LayoutManager(w, h, 0, 0);
    }
    public LayoutManager(int width, int height, int horizontalMarginSpace, int verticalMarginSpace) {
        this.width = width;
        this.height = height;
        this.horizontalMarginSpace = horizontalMarginSpace;
        this.verticalMarginSpace = verticalMarginSpace;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }
    public int getCurrentWidth() {
        return currentWidth;
    }
    public void updateComponent(int w, int h) {
        //within vertical bounds
        if(currentHeight + h + verticalMarginSpace < height) {
            currentHeight+= h + verticalMarginSpace;
            if(furthestWidth < w) {
                furthestWidth = x+w + horizontalMarginSpace;
            }
            currentWidth = w+horizontalMarginSpace;
            y = currentHeight-(h);
        }
        //within horizontal bounds, move right and reset vertical location to top
        else if(x+furthestWidth + w + horizontalMarginSpace < width){
            currentHeight = 80+h+verticalMarginSpace;
            x = furthestWidth + 2*horizontalMarginSpace;
            currentWidth = w+ horizontalMarginSpace;
            furthestWidth = x + w + horizontalMarginSpace;
            y = currentHeight-(h);
        }
        else {
            System.out.println("Error: Make Panel larger");
            y = -1;
        }
    }
    public void updateComponent(int w, int h, int hmargin) {
        customHMargin = hmargin;
        if(currentHeight + h + verticalMarginSpace < height) {
            currentHeight+= h + verticalMarginSpace;
            if(furthestWidth < w) {
                furthestWidth = x+w;
            }
            currentWidth = w;
            y = currentHeight-(h);
        }
        else if(furthestWidth + w + customHMargin < width){
            currentHeight = 85+h+verticalMarginSpace;
            x = furthestWidth + 2*customHMargin;
            currentWidth = w + customHMargin;
            furthestWidth = x + w + customHMargin;
            y = currentHeight-(h);
        }
        else {
            System.out.println("Error: Make Panel larger");
            y = -1;
        }
    }
    public void updateHComponent(int w, int h) {
        if(w + currentWidth + horizontalMarginSpace > furthestWidth) {
            furthestWidth =  w + currentWidth + horizontalMarginSpace;
        }
    }
    public int getX() {
        if(customHMargin == -1) {

            return x + horizontalMarginSpace;
        }
        else {
            int temp = customHMargin;
            customHMargin = -1;
            return x + temp;
        }
    }
    public int getY() {
        return y;
    }
    public int getTextX() {
        if(customHMargin == -1) {

            return x+currentWidth + horizontalMarginSpace + horizontalMarginSpace;
        }
        else {
            int temp = customHMargin;
            customHMargin = -1;
            return x + currentWidth + temp;
        }
    }
    public int getFurthestWidth() {
        return furthestWidth;
    }
    public void setX(int num) {
        x = num;
    }
    public void setY(int num) {
        y = num;
    }

}

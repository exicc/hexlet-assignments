package exercise;

// BEGIN
class Segment {
    private Point beginPoint;
    private Point endPoint;
    public Segment(Point point1, Point point2) {
        this.beginPoint = point1;
        this.endPoint = point2;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int midX = (beginPoint.getX() + endPoint.getX() / 2);
        int midY = (beginPoint.getY() + endPoint.getY() / 2);
        return new Point(midX, midY);
    }
}
// END

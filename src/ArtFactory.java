public class ArtFactory {
    public static ArtDrawType create(String drawType) {
        if (drawType == null) {
            return null;
        } else if ("OILART".equalsIgnoreCase(drawType)) {
            return new OilArt();
        } else if ("PORTRAIT".equalsIgnoreCase(drawType)) {
            return new PortraitArt();
        } else if ("DIGITALART".equalsIgnoreCase(drawType)) {
            return new DigitalArt();
        }
        throw new IllegalArgumentException("Undefined art type");
    }
}

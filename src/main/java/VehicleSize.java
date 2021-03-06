public enum VehicleSize {
    COMPACT(1),
    LARGE(2);

    private final int size;
    VehicleSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public int compareSize(VehicleSize vs) {
        return size <= vs.getSize() ? -1 : 1;
    }
}
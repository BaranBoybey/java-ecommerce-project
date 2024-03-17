public enum State {
    ALABAMA,
    ALASKA,
    ARIZONA,
    ARKANSAS,
    CALIFORNIA,
    COLORADO,
    CONNECTICUT,
    DELAWARE,
    FLORIDA,
    GEORGIA,
    HAWAII,
    IDAHO,
    ILLINOIS,
    INDIANA,
    IOWA,
    KANSAS,
    KENTUCKY,
    LOUISIANA,
    MAINE,
    MARYLAND,
    MASSACHUSETTS,
    MICHIGAN,
    MINNESOTA,
    MISSISSIPPI,
    MISSOURI,
    MONTANA,
    NEBRASKA,
    NEVADA,
    NEW_HAMPSHIRE("New Hampshire"),
    NEW_JERSEY("New Jersey"),
    NEW_MEXICO("New Mexico"),
    NEW_YORK("New York"),
    NORTH_CAROLINA("North Carolina"),
    NORTH_DAKOTA("North Dakota"),
    OHIO,
    OKLAHOMA,
    OREGON,
    PENNSYLVANIA,
    RHODE_ISLAND("Rhode Island"),
    SOUTH_CAROLINA("South Carolina"),
    SOUTH_DAKOTA("South Dakota"),
    TENNESSEE,
    TEXAS,
    UTAH,
    VERMONT,
    VIRGINIA,
    WASHINGTON,
    WEST_VIRGINIA("West Virginia"),
    WISCONSIN,
    WYOMING;

    private final String name;

    State() {
        this.name = name().replace("_", " "); // Convert enum name to display name
    }

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

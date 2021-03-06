package game_of_life;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GameSettings {

    private int gameboardWidth = 1000;
    private int gameboardHeight = 800;
    private int cellResolution = 5;

    private Integer percentageOfRandomFilling = 50;
    private Set<PatternOnPosition> patternsOnPositions;

    private String gameVariationCode = "B23/S3";
    private Set<Integer> bFactors = getFactors(gameVariationCode.split("/")[0]);
    private Set<Integer> sFactors = getFactors(gameVariationCode.split("/")[1]);

    private long refreshingPeriodInMilliseconds = 100;

    private Color backgroundColor = Color.BLACK;
    private Color cellColor = Color.GREEN;

    private Set<Integer> getFactors(String sideOfVariationCode) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i < sideOfVariationCode.length(); i++) {
            factors.add(Character.getNumericValue(sideOfVariationCode.charAt(i)));
        }
        return factors;
    }

    public long getRefreshingPeriodInMilliseconds() {
        return refreshingPeriodInMilliseconds;
    }

    public void setRefreshingPeriodInMilliseconds(long refreshingPeriodInMilliseconds) throws Exception {
        if (refreshingPeriodInMilliseconds <= 0) {
            throw new Exception("Refreshing period must be greater than 0!");
        }
        this.refreshingPeriodInMilliseconds = refreshingPeriodInMilliseconds;
    }

    public Integer getPercentageOfRandomFilling() {
        return percentageOfRandomFilling;
    }

    public void setPercentageOfRandomFilling(int percentageOfRandomFilling) throws Exception {
        patternsOnPositions = null;
        if (percentageOfRandomFilling < 0 || percentageOfRandomFilling > 100) {
            throw new Exception("Percentage must be between 0% and 100%");
        }
        this.percentageOfRandomFilling = percentageOfRandomFilling;
    }

    public Set<PatternOnPosition> getPatternsOnPositions() {
        return patternsOnPositions;
    }

    public void setPatternsOnPositions(Set<PatternOnPosition> patternsOnPositions) throws Exception {
        percentageOfRandomFilling = null;
        if (patternsOnPositions == null) {
            throw new Exception("Patterns set is empty!");
        }
        this.patternsOnPositions = patternsOnPositions;
    }

    public int getGameboardWidth() {
        return gameboardWidth;
    }

    public void setGameboardWidth(int gameboardWidth) {
        this.gameboardWidth = gameboardWidth;
    }

    public int getGameboardHeight() {
        return gameboardHeight;
    }

    public void setGameboardHeight(int gameboardHeight) {
        this.gameboardHeight = gameboardHeight;
    }

    public int getCellResolution() {
        return cellResolution;
    }

    public void setCellResolution(int cellResolution) throws Exception {
        if (gameboardHeight <= 0 || gameboardWidth <= 0 || cellResolution <= 0) {
            throw new Exception("Value must be greater than 0!");
        }
        this.cellResolution = cellResolution;
    }

    public String getGameVariationCode() {
        return gameVariationCode;
    }

    public void setGameVariationCode(String gameVariationCode) throws Exception {
        if (!gameVariationCode.matches("B[0-8]*[/]S[0-8]*")) {
            throw new Exception("Incorrect code.");
        }
        this.gameVariationCode = gameVariationCode;
        this.bFactors = getFactors(gameVariationCode.split("/")[0]);
        this.sFactors = getFactors(gameVariationCode.split("/")[1]);
    }

    public void setRefreshingFrequency(long refreshingFrequency) {
        this.refreshingPeriodInMilliseconds = 1000 / refreshingFrequency;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getCellColor() {
        return cellColor;
    }

    public void setCellColor(Color cellColor) {
        this.cellColor = cellColor;
    }

    int getLogicWidth() {
        return gameboardWidth / cellResolution;
    }

    int getLogicHeight() {
        return gameboardHeight / cellResolution;
    }

    Set<Integer> getbFactors() {
        return bFactors;
    }

    Set<Integer> getsFactors() {
        return sFactors;
    }
}

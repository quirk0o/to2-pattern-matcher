package pl.edu.agh.to2.frazeusz.pattern_matcher;

public interface IMatchProvider {
    void onMatchCompleted();
    void addListener(IMatchListener listener);
}

package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one)
        solve(model.height(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    private void solve(int i, int from, int to, int temp) {
        if (i == 0) {
            return;
        }
        solve(i-1, from, temp, to);
        model.move(from, to);
        solve(i-1, temp, to, from);
    }

}

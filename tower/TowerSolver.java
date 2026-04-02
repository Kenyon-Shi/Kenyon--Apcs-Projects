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
  // [ solve method here ]
  //
  public void solve(int n, int source, int destination, int spare)
  {
    if (n <= 0)
    {
      return;
    }

    if (n == 1)
    {
      model.move(source, destination);
    }
    else
    {
      solve(n - 1, source, spare, destination);
      model.move(source, destination);
      solve(n - 1, spare, destination, source);
    }
  }
}

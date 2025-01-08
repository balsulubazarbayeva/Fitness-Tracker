class WorkoutPlan {
    private String name;
    private int duration; // in minutes

    public WorkoutPlan(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "WorkoutPlan{name='" + name + '\'' + ", duration=" + duration + " minutes}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WorkoutPlan that = (WorkoutPlan) obj;
        return duration == that.duration && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + duration;
    }
}

class User {
    private String username;
    private int age;
    private double weight; // in kilograms

    public User(String username, int age, double weight) {
        this.username = username;
        this.age = age;
        this.weight = weight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User{username='" + username + '\'' + ", age=" + age + ", weight=" + weight + " kg}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return age == user.age && Double.compare(user.weight, weight) == 0 && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode() * 31 + age;
    }
}

class FitnessApp {
    private String appName;
    private User user;
    private WorkoutPlan workoutPlan;

    public FitnessApp(String appName, User user, WorkoutPlan workoutPlan) {
        this.appName = appName;
        this.user = user;
        this.workoutPlan = workoutPlan;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public void filterWorkoutsByDuration(int minDuration) {
        if (workoutPlan.getDuration() >= minDuration) {
            System.out.println("Workout matches filter: " + workoutPlan);
        } else {
            System.out.println("No matching workouts.");
        }
    }

    @Override
    public String toString() {
        return "FitnessApp{appName='" + appName + '\'' + ", user=" + user + ", workoutPlan=" + workoutPlan + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        WorkoutPlan plan1 = new WorkoutPlan("Morning Yoga", 30);
        WorkoutPlan plan2 = new WorkoutPlan("Evening Run", 45);

        User user = new User("JohnDoe", 25, 70.5);

        FitnessApp app = new FitnessApp("FitLife", user, plan1);

        System.out.println(app);

        app.filterWorkoutsByDuration(20);
        System.out.println("Are plans equal? " + plan1.equals(plan2));
    }
}

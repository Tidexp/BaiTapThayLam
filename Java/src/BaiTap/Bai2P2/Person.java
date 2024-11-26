package BaiTap.Bai2P2;

public class Person {
    private String fullName;
    private int birthYear;
    private double[] scores = new double[9];
    private String[] subjects = {"Toan", "Ly", "Hoa", "Sinh", "Van", "Su", "Dia", "Cong Dan", "Tieng Anh"}; 

    public Person(String fullName, int birthYear, double[] scores) {
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.scores = scores;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getSubjectName(int index) {
        if (index >= 0 && index < subjects.length) {
            return subjects[index];
        } else {
            return "Invalid subject index";
        }
    }

    public double[] getScores() {
        return scores;
    }

    public double getAverageScore() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    public String check() {
        double averageScoreCheck = getAverageScore();
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 5) {
                return "Thi lai mon " + subjects[i];  
            }
        }
        
        if (averageScoreCheck > 7) {
            return "Duoc lam luan van";
        } else {
            return "Thi tot nghiep";
        }
    }
    
    @Override 
    public String toString() {
        StringBuilder scoreStr = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            scoreStr.append(subjects[i]).append(": ").append(scores[i]).append(" ");
        }
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", birthYear=" + birthYear +
                ", scores={" + scoreStr.toString().trim() + "}" + // trim() có tác dụng xóa khoảng trắng thừa ở đầu và cuối chuỗi mà nó tác động
                ", averageScore=" + getAverageScore() +
                '}';
    }

    public static void main(String[] args) {
        Person[] persons = new Person[7];

        persons[0] = new Person("Nguyen Van A", 2000, new double[]{8.5, 7.0, 9.0, 6.5, 7.5, 8.0, 9.5, 6.0, 7.0});
        persons[1] = new Person("Nguyen Van B", 2001, new double[]{6.0, 5.5, 7.0, 8.5, 9.0, 7.5, 6.0, 5.5, 8.0});
        persons[2] = new Person("Nguyen Van C", 2002, new double[]{9.0, 8.5, 8.0, 9.5, 9.0, 8.5, 9.0, 8.5, 9.5});
        persons[3] = new Person("Nguyen Van D", 2003, new double[]{5.0, 5.5, 6.0, 7.0, 7.5, 8.0, 6.5, 7.0, 5.5});
        persons[4] = new Person("Nguyen Van E", 2004, new double[]{7.5, 8.0, 7.0, 6.5, 7.0, 8.0, 8.5, 7.5, 7.0});
        persons[5] = new Person("Nguyen Van F", 2005, new double[]{6.5, 6.0, 7.5, 7.0, 8.0, 6.5, 6.0, 7.5, 7.0});
        persons[6] = new Person("Nguyen Van G", 2006, new double[]{8.0, 8.5, 3.0, 8.5, 9.5, 9.0, 8.0, 8.5, 9.0});


        // in ra thong tin hoc vien
        for (Person person : persons) {
            System.out.println(person); //toString sẽ tự động được áp dụng mỗi khi in ra 1 đối tượng
        }


        // in ket qua kiem tra
        System.out.println("\nKet qua kiem tra:");
        for (Person person : persons) {
            System.out.println(person.getFullName() + ": " + person.check());
        }   


        // in so sinh vien tung hang muc
        System.out.println();
        int luanVanCount = 0;
        int totNghiepCount = 0;
        int thiLaiCount = 0;

        for (Person person : persons) {
            String result = person.check();
            if (result.contains("Thi lai mon")) {
                thiLaiCount++;
            } else if (result.equals("Duoc lam luan van")) {
                luanVanCount++;
            } else if (result.equals("Thi tot nghiep")) {
                totNghiepCount++;
            }
        }

        System.out.println("So sinh vien lam luan van: " + luanVanCount);
        System.out.println("So sinh vien thi tot nghiep: " + totNghiepCount);
        System.out.println("So sinh vien thi lai: " + thiLaiCount);
    }
}

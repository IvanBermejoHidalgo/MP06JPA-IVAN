    import Entities.*;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class FileAccessor {

        private ArrayList<Profesor> teachersList = new ArrayList<>();
        private ArrayList<Departamento> departmentsList = new ArrayList<>();
        private ArrayList<Sesion> sessionsList = new ArrayList<>();
        private ArrayList<Asignatura> subjectsList = new ArrayList<>();
        private ArrayList<Grupo> groupsList = new ArrayList<>();


        private Connection connection;

        public FileAccessor() throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String password = "postgres";
            connection = DriverManager.getConnection(url, user, password);
        }

        public List<Profesor> getTeachersList() {
            return teachersList;
        }

        public List<Departamento> getDepartmentsList() {
            return departmentsList;
        }

        public List<Sesion> getSessionsList() {
            return sessionsList;
        }

        public List<Asignatura> getSubjectsList() {
            return subjectsList;
        }

        public List<Grupo> getGroupsList() {
            return groupsList;
        }

        public void insertFromFileDepartamento(String filename) throws IOException, SQLException {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    if (departamentoExiste(Integer.parseInt(data[0]))) {
                        System.out.println("No se puede insertar porque el código " + data[0] + " ya existe.");
                        continue;
                    }

                    String query = "INSERT INTO departments (code, name, phone) VALUES (?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setInt(1, Integer.parseInt(data[0]));
                        preparedStatement.setString(2, data[1]);
                        preparedStatement.setString(3, data[2]);

                        preparedStatement.executeUpdate();
                    }
                }
            }
        }

        // Método para verificar si un departamento con el código especificado ya existe
        private boolean departamentoExiste(int code) throws SQLException {
            String query = "SELECT COUNT(*) FROM departments WHERE code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, code);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
            return false;
        }


        public void insertFromFileSesion(String filename) throws IOException, SQLException {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    if (weekDayExists(data[0])) {
                        System.out.println("El día de la semana '" + data[0] + "' ya está siendo usado. La sesión no se agregará.");
                        continue;
                    }

                    if (!grupoExists(data[5])) {
                        System.out.println("El código del grupo '" + data[5] + "' no existe. La sesión no se agregará.");
                        continue;
                    }
                    String query = "INSERT INTO sessions (week_day, starts, finishes, teacher_id, subject_code, group_code) VALUES (?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        //preparedStatement.setInt(1, Integer.parseInt(data[0]));
                        //preparedStatement.setString(2, data[1]);
                        //preparedStatement.setString(3, data[2]);

                        preparedStatement.setString(1, data[0]);
                        preparedStatement.setTime(2, Time.valueOf(data[1]));
                        preparedStatement.setTime(3, Time.valueOf(data[2]));
                        preparedStatement.setInt(4, Integer.parseInt(data[3]));
                        preparedStatement.setString(5, data[4]);
                        preparedStatement.setString(6, data[5]);


                        preparedStatement.executeUpdate();
                    }
                }
            }
        }

        private boolean weekDayExists(String weekDay) throws SQLException {
            String query = "SELECT COUNT(*) FROM sessions WHERE week_day = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, weekDay);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
            return false;
        }

        // Método para verificar si el código del grupo existe
        private boolean grupoExists(String code) throws SQLException {
            String query = "SELECT COUNT(*) FROM groups WHERE code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, code);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
            return false;
        }

        public void insertFromFileAsignatura(String filename) throws IOException, SQLException {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    if (asignaturaExiste(data[0])) {
                        System.out.println("No se puede insertar porque el código " + data[0] + " ya existe.");
                        continue;
                    }

                    String query = "INSERT INTO subjects (code, description) VALUES (?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, data[0]);
                        preparedStatement.setString(2, data[1]);

                        preparedStatement.executeUpdate();
                    }
                }
            }
        }

        // Método para verificar si una asignatura con el código especificado ya existe
        private boolean asignaturaExiste(String code) throws SQLException {
            String query = "SELECT COUNT(*) FROM subjects WHERE code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, code);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
            return false;
        }


        public void insertFromFileGrupo(String filename) throws IOException, SQLException {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    if (grupoExiste(data[0])) {
                        System.out.println("No se puede insertar porque el código " + data[0] + " ya existe.");
                        continue;
                    }

                    String query = "INSERT INTO groups (code, curriculum, course) VALUES (?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, data[0]);
                        preparedStatement.setString(2, data[1]);
                        preparedStatement.setInt(3, Integer.parseInt(data[2]));

                        preparedStatement.executeUpdate();
                    }
                }
            }
        }

        // Método para verificar si un grupo con el código especificado ya existe
        private boolean grupoExiste(String code) throws SQLException {
            String query = "SELECT COUNT(*) FROM groups WHERE code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, code);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
            return false;
        }



        public void insertFromFileProfesores(String filename) throws IOException, SQLException {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    if (profesorExiste(Integer.parseInt(data[0]))) {
                        System.out.println("No se puede insertar porque el código del profesor " + data[0] + " ya existe.");
                        continue;
                    }

                    if (!departamentoExiste2(Integer.parseInt(data[4]))) {
                        System.out.println("No se puede insertar porque el código del departamento " + data[4] + " no existe.");
                        continue;
                    }

                    String query = "INSERT INTO teachers (id, firstname, lastname, email, department_code) VALUES (?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setInt(1, Integer.parseInt(data[0]));
                        preparedStatement.setString(2, data[1]);
                        preparedStatement.setString(3, data[2]);
                        preparedStatement.setString(4, data[3]);
                        preparedStatement.setInt(5, Integer.parseInt(data[4]));

                        preparedStatement.executeUpdate();
                    }
                }
            }
        }

        // Método para verificar si un profesor con el ID especificado ya existe
        private boolean profesorExiste(int id) throws SQLException {
            String query = "SELECT COUNT(*) FROM teachers WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
            return false;
        }

        // Método para verificar si un departamento con el código especificado existe
        private boolean departamentoExiste2(int code) throws SQLException {
            String query = "SELECT COUNT(*) FROM departments WHERE code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, code);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
            return false;
        }

        public void closeConnection() {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

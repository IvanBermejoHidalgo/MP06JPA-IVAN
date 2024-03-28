import Entities.*;

import jakarta.persistence.*;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("SchoolPU");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Departamentos");
            System.out.println("2. Asignaturas");
            System.out.println("3. Grupos");
            System.out.println("4. Sesiones");
            System.out.println("5. Profesores");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //listarEntidades();
                    //EntityManager entityManager = entityManagerFactory.createEntityManager();
                    //listarDepartamentos(entityManager);
                    //break;

                    do {
                        System.out.println("1. Listar departamentos");
                        System.out.println("2. Añadir departamentos");
                        System.out.println("3. Actualizar departamentos");
                        System.out.println("4. Eliminar departamentos");
                        System.out.println("5. Añadir departamentos desde fichero.");
                        System.out.println("6. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                EntityManager entityManager = entityManagerFactory.createEntityManager();
                                listarDepartamentos(entityManager);
                                break;
                            case 2:
                                insertarDepartamento();
                                break;
                            case 3:
                                actualizarDepartamento();
                                break;
                            case 4:
                                eliminarDepartamento();
                                break;
                            case 5:
                                //eliminarDepartamento();
                                //fa.readDepartmentsFile();
                                //break;
                                //FileAccessor fileAccessor;
                                FileAccessor fileAccessor;
                                try {
                                    fileAccessor = new FileAccessor();
                                    fileAccessor.insertFromFileDepartamento("departments.txt");
                                    System.out.println("Departamentos añadidos.");
                                    fileAccessor.closeConnection();
                                } catch (SQLException | IOException e) {
                                    e.printStackTrace();
                                }
                            case 6:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione otra opción.");
                        }

                    }while (opcion != 5);
                    break;

                case 2:
                    do {
                        System.out.println("1. Listar asignatura");
                        System.out.println("2. Añadir asignatura");
                        System.out.println("3. Actualizar asignatura");
                        System.out.println("4. Eliminar asignatura");
                        System.out.println("5. Añadir asignatura desde fichero.");
                        System.out.println("6. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                EntityManager entityManager = entityManagerFactory.createEntityManager();
                                listarAsignaturas(entityManager);
                                break;
                            case 2:
                                insertarAsignatura();
                                break;
                            case 3:
                                actualizarAsignatura();
                                break;
                            case 4:
                                eliminarAsignatura();
                                break;
                            case 5:
                                //eliminarDepartamento();
                                //fa.readDepartmentsFile();
                                //break;
                                //FileAccessor fileAccessor;
                                FileAccessor fileAccessor;
                                try {
                                    fileAccessor = new FileAccessor();
                                    fileAccessor.insertFromFileAsignatura("subjects.txt");
                                    System.out.println("Asignaturas añadidos.");
                                    fileAccessor.closeConnection();
                                } catch (SQLException | IOException e) {
                                    e.printStackTrace();
                                }
                            case 6:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione otra opción.");
                        }

                    }while (opcion != 5);
                    break;

                case 3:
                    do {
                        System.out.println("1. Listar grupos.");
                        System.out.println("2. Añadir grupos.");
                        System.out.println("3. Actualizar grupos.");
                        System.out.println("4. Eliminar grupos.");
                        System.out.println("5. Añadir grupos desde fichero.");
                        System.out.println("6. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                EntityManager entityManager = entityManagerFactory.createEntityManager();
                                listarGrupos(entityManager);
                                break;
                            case 2:
                                insertarGrupo();
                                break;
                            case 3:
                                actualizarGrupo();
                                break;
                            case 4:
                                eliminarGrupo();
                                break;
                            case 5:
                                //eliminarDepartamento();
                                //fa.readDepartmentsFile();
                                //break;
                                //FileAccessor fileAccessor;
                                FileAccessor fileAccessor;
                                try {
                                    fileAccessor = new FileAccessor();
                                    fileAccessor.insertFromFileGrupo("groups.txt");
                                    System.out.println("Grupos añadidos.");
                                    fileAccessor.closeConnection();
                                } catch (SQLException | IOException e) {
                                    e.printStackTrace();
                                }
                            case 6:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione otra opción.");
                        }

                    }while (opcion != 5);
                    break;
                case 4:
                    do {
                        System.out.println("1. Listar sesiones");
                        System.out.println("2. Añadir sesiones");
                        System.out.println("3. Actualizar sesiones");
                        System.out.println("4. Eliminar sesiones");
                        System.out.println("5. Añadir sesiones desde fichero.");
                        System.out.println("6. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                EntityManager entityManager = entityManagerFactory.createEntityManager();
                                listarSesiones(entityManager);
                                break;
                            case 2:
                                insertarSesion();
                                break;
                            case 3:
                                actualizarSesion();
                                break;
                            case 4:
                                eliminarSesion();
                                break;
                            case 5:
                                //eliminarDepartamento();
                                //fa.readDepartmentsFile();
                                //break;
                                //FileAccessor fileAccessor;
                                FileAccessor fileAccessor;
                                try {
                                    fileAccessor = new FileAccessor();
                                    fileAccessor.insertFromFileSesion("sessions.txt");
                                    System.out.println("Sesiones añadidas.");
                                    fileAccessor.closeConnection();
                                } catch (SQLException | IOException e) {
                                    e.printStackTrace();
                                }
                            case 6:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione otra opción.");
                        }

                    }while (opcion != 5);
                    break;

                case 5:
                    do {
                        System.out.println("1. Listar profesores");
                        System.out.println("2. Añadir profesor");
                        System.out.println("3. Actualizar profesor");
                        System.out.println("4. Eliminar profesor");
                        System.out.println("5. Añadir profesores desde fichero.");
                        System.out.println("6. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                EntityManager entityManager = entityManagerFactory.createEntityManager();
                                listarProfesores(entityManager);
                                break;
                            case 2:
                                insertarProfesor();
                                break;
                            case 3:
                                actualizarProfesor();
                                break;
                            case 4:
                                eliminarProfesor();
                                break;
                            case 5:
                                //eliminarDepartamento();
                                //fa.readDepartmentsFile();
                                //break;
                                //FileAccessor fileAccessor;
                                FileAccessor fileAccessor;
                                try {
                                    fileAccessor = new FileAccessor();
                                    fileAccessor.insertFromFileProfesores("teachers.txt");
                                    System.out.println("Profesores añadidos.");
                                    fileAccessor.closeConnection();
                                } catch (SQLException | IOException e) {
                                    e.printStackTrace();
                                }
                            case 6:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione otra opción.");
                        }

                    }while (opcion != 5);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione otra opción.");
            }

        } while (opcion != 6);

        scanner.close();
        entityManagerFactory.close();
    }

    private static void listarDepartamentos(EntityManager entityManager) {
        TypedQuery<Departamento> query = entityManager.createQuery("FROM Departamento", Departamento.class);
        List<Departamento> departamentos = query.getResultList();
        for (Departamento departamento : departamentos) {
            System.out.println("ID: " + departamento.getCode() + ", Nombre: " + departamento.getName() + ", Teléfono: " + departamento.getPhone());
        }
    }

    private static void insertarDepartamento() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insertar un nuevo departamento:");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        try {
            transaction.begin();

            Departamento departamento = new Departamento();
            departamento.setCode(codigo);
            departamento.setName(nombre);
            departamento.setPhone(telefono);

            entityManager.persist(departamento);

            transaction.commit();
            //scanner.close();
            System.out.println("Departamento insertado correctamente.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al insertar el departamento: " + e.getMessage());
        } finally {
            entityManager.close();
            //scanner.close();
        }
    }

    private static void actualizarDepartamento() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Actualizar un departamento:");
        System.out.print("ID del departamento a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        try {
            transaction.begin();

            Departamento departamento = entityManager.find(Departamento.class, id);
            if (departamento == null) {
                System.out.println("Departamento con ID " + id + " no encontrado.");
            } else {
                departamento.setName(nuevoNombre);
                departamento.setPhone(nuevoTelefono);

                entityManager.merge(departamento);

                transaction.commit();
                System.out.println("Departamento actualizado correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar el departamento: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void eliminarDepartamento() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eliminar un departamento:");
        System.out.print("ID del departamento a eliminar: ");
        int id = scanner.nextInt();

        try {
            transaction.begin();

            Departamento departamento = entityManager.find(Departamento.class, id);
            if (departamento == null) {
                System.out.println("Departamento con ID " + id + " no encontrado.");
            } else {
                entityManager.remove(departamento);

                transaction.commit();
                System.out.println("Departamento eliminado correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar el departamento: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    private static void listarAsignaturas(EntityManager entityManager) {
        TypedQuery<Asignatura> query = entityManager.createQuery("FROM Asignatura", Asignatura.class);
        List<Asignatura> asignaturas = query.getResultList();
        for (Asignatura assignatura : asignaturas) {
            System.out.println("Código: " + assignatura.getCode() + ", Descripción: " + assignatura.getDescription());
        }
    }

    private static void insertarAsignatura() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insertar una nueva asignatura:");
        System.out.print("Código: ");
        String codigo = scanner.next();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        try {
            transaction.begin();

            Asignatura asignatura = new Asignatura();
            asignatura.setCode(codigo);
            asignatura.setDescription(descripcion);

            entityManager.persist(asignatura);

            transaction.commit();
            //scanner.close();
            System.out.println("Asignatura insertada correctamente.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al insertar la asignatura: " + e.getMessage());
        } finally {
            entityManager.close();
            //scanner.close();
        }
    }

    private static void actualizarAsignatura() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Actualizar una asignatura:");
        System.out.print("Código de la asignatura a actualizar: ");
        //int id = scanner.nextInt();
        String codigo = scanner.next();
        scanner.nextLine(); // Consumir el salto de línea
        //System.out.print("Nuevo nombre: ");
        //String nuevoNombre = scanner.nextLine();
        System.out.print("Nueva descripción: ");
        String nuevoDescripcion = scanner.nextLine();

        try {
            transaction.begin();

            Asignatura asignatura = entityManager.find(Asignatura.class, codigo);
            if (asignatura == null) {
                System.out.println("Asignatura con código " + codigo + " no encontrada.");
            } else {
                asignatura.setDescription(nuevoDescripcion);

                entityManager.merge(asignatura);

                transaction.commit();
                System.out.println("Asignatura actualizada correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar la asignatura: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void eliminarAsignatura() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eliminar una asignatura:");
        System.out.print("Código de la asignatura a eliminar: ");
        //int id = scanner.nextInt();
        String codigo = scanner.nextLine();

        try {
            transaction.begin();

            Asignatura asignatura = entityManager.find(Asignatura.class, codigo);
            if (asignatura == null) {
                System.out.println("Asignatura con código " + codigo + " no encontrada.");
            } else {
                entityManager.remove(asignatura);

                transaction.commit();
                System.out.println("Asignatura eliminada correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar la asignatura: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void listarGrupos(EntityManager entityManager) {
        TypedQuery<Grupo> query = entityManager.createQuery("FROM Grupo", Grupo.class);
        List<Grupo> grupos = query.getResultList();
        for (Grupo grupo : grupos) {
            System.out.println("Código: " + grupo.getCode() + ", Currículum: " + grupo.getCurriculum() + ", Curso: " + grupo.getCourse());
        }
    }

    private static void insertarGrupo() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insertar un nuevo grupo:");
        System.out.print("Código: ");
        String codigo = scanner.next();
        scanner.nextLine();
        System.out.print("Currículum: ");
        String curriculum = scanner.nextLine();
        System.out.print("Curso: ");
        int curso = scanner.nextInt();

        try {
            transaction.begin();

            Grupo grupo = new Grupo();
            grupo.setCode(codigo);
            grupo.setCurriculum(curriculum);
            grupo.setCourse(curso);

            entityManager.persist(grupo);

            transaction.commit();
            //scanner.close();
            System.out.println("Grupo insertado correctamente.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al insertar el grupo: " + e.getMessage());
        } finally {
            entityManager.close();
            //scanner.close();
        }
    }

    private static void actualizarGrupo() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Actualizar un grupo:");
        System.out.print("Código del grupo a actualizar: ");
        String codigo = scanner.next();
        scanner.nextLine();
        System.out.print("Currículum: ");
        String curriculum = scanner.nextLine();
        System.out.print("Curso: ");
        int curso = scanner.nextInt();

        try {
            transaction.begin();

            Grupo grupo = entityManager.find(Grupo.class, codigo);
            if (grupo == null) {
                System.out.println("Grupo con código " + codigo + " no encontrado.");
            } else {
                grupo.setCurriculum(curriculum);
                grupo.setCourse(curso);

                entityManager.merge(grupo);

                transaction.commit();
                System.out.println("Grupo actualizado correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar el grupo: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void eliminarGrupo() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eliminar un grupo:");
        System.out.print("Código del grupo a eliminar: ");
        //int id = scanner.nextInt();
        String codigo = scanner.nextLine();

        try {
            transaction.begin();

            Grupo grupo = entityManager.find(Grupo.class, codigo);
            if (grupo == null) {
                System.out.println("Grupo con código " + codigo + " no encontrado.");
            } else {
                entityManager.remove(grupo);

                transaction.commit();
                System.out.println("Grupo eliminado correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar el grupo: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    private static void listarSesiones(EntityManager entityManager) {
        TypedQuery<Sesion> query = entityManager.createQuery("FROM Sesion", Sesion.class);
        List<Sesion> sesions = query.getResultList();
        for (Sesion sesion : sesions) {
            System.out.println("Dia de la semana: " + sesion.getWeek_day() + ", Empieza (hh:mm:ss): " + sesion.getStarts() + ", Acaba (hh:mm:ss): " + sesion.getFinishes() + ", Listar ID profesor: " + sesion.getProfesor() + ", Listar CODE Asignatura: " + sesion.getAsignatura() + ", Listar CODE Grupo: " + sesion.getGrupo());
        }
    }

    private static void insertarSesion() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insertar una nueva sesión:");
        System.out.print("Dia de la semana: ");
        String dia = scanner.next();
        scanner.nextLine();
        System.out.print("Hora que empieza (hh:mm:ss): ");
        Time empieza = Time.valueOf(scanner.nextLine());
        System.out.print("Hora que acaba (hh:mm:ss): ");
        Time acaba = Time.valueOf(scanner.nextLine());
        //int idprofesor = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("Código de la asignatura: ");
        //String codigoasignatura = scanner.nextLine();


        try {
            transaction.begin();

            Sesion sesion = new Sesion();
            sesion.setWeek_day(dia);
            sesion.setStarts(empieza);
            sesion.setFinishes(acaba);
            //sesion.setTeacher_id(idprofesor);
            //sesion.setSubject_code(codigoasignatura);

            entityManager.persist(sesion);

            transaction.commit();
            //scanner.close();
            System.out.println("Sesion insertada correctamente.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al insertar la sesion: " + e.getMessage());
        } finally {
            entityManager.close();
            //scanner.close();
        }
    }

    private static void actualizarSesion() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Actualizar una sesion:");
        System.out.print("Dia de la sesion a actualizar: ");
        String dia = scanner.next();
        scanner.nextLine();
        System.out.print("Hora que empieza (hh:mm:ss): ");
        Time empieza = Time.valueOf(scanner.nextLine());
        System.out.print("Hora que acaba (hh:mm:ss): ");
        Time acaba = Time.valueOf(scanner.nextLine());
        //int idprofesor = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("Código de la asignatura: ");
        //String codigoasignatura = scanner.nextLine();

        try {
            transaction.begin();

            Sesion sesion = entityManager.find(Sesion.class, dia);
            if (sesion == null) {
                System.out.println("Sesion con el dia de la semana " + dia + " no encontrado.");
            } else {
                sesion.setStarts(empieza);
                sesion.setFinishes(acaba);
                //sesion.setTeacher_id(idprofesor);
                //sesion.setSubject_code(codigoasignatura);

                // Guardar los cambios en la base de datos
                entityManager.merge(sesion);

                transaction.commit();
                System.out.println("Sesion actualizada correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar la sesion: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void eliminarSesion() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eliminar una sesión:");
        System.out.print("Dia de la semana de la sesión a eliminar: ");
        //int id = scanner.nextInt();
        String dia = scanner.nextLine();

        try {
            transaction.begin();

            Sesion sesion = entityManager.find(Sesion.class, dia);
            if (sesion == null) {
                System.out.println("Sesion con el dia de la semana " + dia + " no encontrado.");
            } else {
                entityManager.remove(sesion);

                transaction.commit();
                System.out.println("Sesion eliminada correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar la sesión: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void listarProfesores(EntityManager entityManager) {
        TypedQuery<Profesor> query = entityManager.createQuery("FROM Profesor", Profesor.class);
        List<Profesor> profesors = query.getResultList();
        for (Profesor profesor : profesors) {
            System.out.println("id: " + profesor.getId() + ", Nombre: " + profesor.getFirstname() + ", Apellido: " + profesor.getLastname() + " EMAIL: " + profesor.getEmail() + "Código del departamento: " + profesor.getDepartment_code());
        }
    }

    private static void insertarProfesor() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insertar un nuevo profesor:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        System.out.print("Código del departamento: ");
        int codigodepar = scanner.nextInt();
        scanner.nextLine();

        try {
            transaction.begin();

            Profesor profesor = new Profesor();
            profesor.setId(id);
            profesor.setFirstname(nombre);
            profesor.setLastname(apellido);
            profesor.setEmail(email);
            profesor.setDepartment_code(codigodepar);

            entityManager.persist(profesor);

            transaction.commit();
            //scanner.close();
            System.out.println("Profesor insertado correctamente.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al insertar el profesor: " + e.getMessage());
        } finally {
            entityManager.close();
            //scanner.close();
        }
    }

    private static void actualizarProfesor() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Actualizar un profesor:");
        System.out.print("Profesor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        System.out.print("Código del departamento: ");
        int codigodepar = scanner.nextInt();
        scanner.nextLine();

        try {
            transaction.begin();

            Profesor profesor = entityManager.find(Profesor.class, id);
            if (profesor == null) {
                System.out.println("ID del profesor " + id + " no encontrado.");
            } else {
                profesor.setFirstname(nombre);
                profesor.setLastname(apellido);
                profesor.setEmail(email);
                profesor.setDepartment_code(codigodepar);

                entityManager.merge(profesor);

                transaction.commit();
                System.out.println("Profesor actualizado correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar el profesor: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void eliminarProfesor() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eliminar un profesor:");
        System.out.print("ID del profesor a eliminar: ");
        //int id = scanner.nextInt();
        String id = scanner.nextLine();

        try {
            transaction.begin();

            Profesor profesor = entityManager.find(Profesor.class, id);
            if (profesor == null) {
                System.out.println("ID del profesor " + id + " no encontrado.");
            } else {
                entityManager.remove(profesor);

                transaction.commit();
                System.out.println("Profesor eliminado correctamente.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar el perofesor: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}


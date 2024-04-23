package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Customer;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findAllStudents() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    public void deleteStudentById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}

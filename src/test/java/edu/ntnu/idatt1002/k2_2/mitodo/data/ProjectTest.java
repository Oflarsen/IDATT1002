package edu.ntnu.idatt1002.k2_2.mitodo.data;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    Project project = new Project("project1");
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Nested
    @DisplayName("Test to make sure add Subproject works")
    class addSubproject{
        @Test
        void addSubprojectSuccess() {
            assertEquals(project.getSubprojects().size(), 0);
            project.addSubproject("subproject", Color.AQUA);
            assertEquals(project.getSubprojects().size(), 1);
        }
        @Test
        void addSubprojectFail(){
            try{
                project.addSubproject("subproject", Color.AQUA);
            }catch (IllegalArgumentException e){
                project.removeSubproject(new Subproject("subproject", Color.AQUA));
                assertEquals(e.getMessage(), "Subproject already in project");
            }
        }
        //TODO Add test for different color, what would happen?

    }

    @Nested
    @DisplayName("Test to make sure removeSubject works")
    class removeSubproject{
        /*
        @Test
        void removeSubprojectTrue(){
            Subproject subproject = new Subproject("subproject", Color.AQUA);
            project.addSubproject(subproject.getTitle(), subproject.getColor());
            assertTrue(project.removeSubproject(subproject));
        }

         */

        @Test
        void removeSubprojectFalse(){
            assertFalse(project.removeSubproject(new Subproject("subproject", Color.AQUA)));
        }
    }

    @Test
    void testEquals() {
    }
}
package by.it.academy.ob.model.cars;

public class Model {
        private Long id;
        private String name;
        private Make make;
        private Long make_id;

        public Model(Long id, String name, Make make) {
            this.id = id;
            this.name = name;
            this.make = make;
            this.make_id = make.getId();
        }
    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Make getMake() {
            return make;
        }

        public void setMake(Make make) {
            this.make = make;
        }

        public Long getMake_id() {
            return make_id;
        }

        public void setMake_id(Long make_id) {
            this.make_id = make.getId();
        }
}

package Java_Examples.AutoDesignPattern.BuilderPattern;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Register {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String telephone;
    private final String password;
    private final String conformPassword;

    public Register(RegisterBuilder registerBuilder) {
        this.firstName = registerBuilder.firstName;
        this.lastName = registerBuilder.lastName;
        this.email = registerBuilder.email;
        this.telephone = registerBuilder.telephone;
        this.password = registerBuilder.password;
        this.conformPassword = registerBuilder.conformPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getConformPassword() {
        return conformPassword;
    }

    @Setter
    public static class RegisterBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String telephone;
        private String password;
        private String conformPassword;

        //Setters only:

        public RegisterBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RegisterBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RegisterBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public RegisterBuilder setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public RegisterBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public RegisterBuilder setConformPassword(String conformPassword) {
            this.conformPassword = conformPassword;
            return this;
        }

        public Register build() {
            return new Register(this);
        }

    }
}
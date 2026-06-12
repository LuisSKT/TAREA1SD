package model;

public class claseUsuario {
    private int idusuario;
    private String nombreusuario;
    private String password;
    private String email;
    private String rol;

    public claseUsuario() {
    }

    public claseUsuario(int idusuario, String nombreusuario, String password, String email, String rol) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    public int getIdusuario() { return idusuario; }
    public void setIdusuario(int idusuario) { this.idusuario = idusuario; }

    public String getNombreusuario() { return nombreusuario; }
    public void setNombreusuario(String nombreusuario) { this.nombreusuario = nombreusuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return "Usuario[" + idusuario + "] - " + nombreusuario + " | Email: " + email + " | Rol: " + rol;
    }
}
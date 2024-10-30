package gbs.com.ecommerce.infrastructure.mapper;

public class Formatter {
    private Formatter() {
    }

    public static String formatCepWithHyphen(String cep) {
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }
}

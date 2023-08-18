package org.example.model;

public enum TipoPessoa {

    FISICA {
        @Override
        public boolean validarDocumento(String documento) {
            if (documento.equals("00000000000") ||
                    documento.equals("11111111111") ||
                    documento.equals("22222222222") || documento.equals("33333333333") ||
                    documento.equals("44444444444") || documento.equals("55555555555") ||
                    documento.equals("66666666666") || documento.equals("77777777777") ||
                    documento.equals("88888888888") || documento.equals("99999999999") ||
                    (documento.length() != 11))
                return false;

            char dig10, dig11;
            int sm, i, r, num, peso;

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = documento.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48);
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = documento.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            if ((dig10 == documento.charAt(9)) && (dig11 == documento.charAt(10)))
                return true;

            else return false;
        }
    }, JURIDICA {
        @Override
        public boolean validarDocumento(String documento) {
            return false;
        }
    };

    public abstract boolean validarDocumento(String documento);
}


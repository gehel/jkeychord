package ch.ledcom.jkeychord;

import lombok.Getter;

public enum AlphaGripKey {

                    J(36), V(47),      X(45),     Z(44),
    LEFT_SHIFT(42), C(46), Y(21),      ENTER(28), BACKSPACE(14), RIGHT_SHIFT(42),
                    K(37), L(38),      SPACE(57), TAB(15),


                       G(34),             M(50),
                    F(33), T(20),      N(49), U(22),
                       R(19),             H(35),
                    D(32), E(18),      I(23), COMA(51),
                    W(17), S(31),      O(24), DOT(52),
                    Q(16), A(30),      P(25), B(48);

    @Getter
    private final short code;

    AlphaGripKey(int code) {
        this.code = (short)code;
    }
}

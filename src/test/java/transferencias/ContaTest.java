package transferencias;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente daniel;
    Cliente vanessa;
    Conta contaDaniel;
    Conta contaVanessa;

    @BeforeEach
    void setUp() {
        daniel = new Cliente("Daniel", "123456789", "123456" );
        vanessa = new Cliente("Vanessa", "123987456", "654123");

        contaDaniel = new Conta("1234", "AA123", 100.00, daniel );
        contaVanessa = new Conta("4321", "BB123", 1000.00, vanessa);
    }

    @Test
    public void realizar_Transacao_De_Uma_Conta_Para_Outra(){
        contaDaniel.realizarTransferencia(50.00, contaVanessa);

        assertEquals(50.00, contaDaniel.getSaldo());
        assertEquals(1050.00, contaVanessa.getSaldo());
    }

    @Test
    public void realizar_Transferrencia_Sem_Saldo_Deve_Retornar_Falso(){
        contaDaniel.realizarTransferencia(101.00, contaVanessa);

        assertFalse(false);
    }

    @Test
    public void criando_Um_Cliente_Sem_Os_Dados_Deve_Retornar_Falso(){
        //assertEquals(daniel, contaVanessa.getCliente());
        //assertFalse(false);

    }

    @Test
    public void criando_Um_Cliente_Com_Os_Dados_Deve_Retornar_Verdadeiro(){

        assertEquals(daniel, contaDaniel.getCliente());
    }

}
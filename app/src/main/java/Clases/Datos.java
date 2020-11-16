package Clases;

import java.text.DecimalFormat;

public class Datos
{
    private int CreditoHipotecario;
    private int CreditoAutomotriz;
    private int Axel;
    private int Roxana;

    public Datos()
    {
        CreditoHipotecario = 1000000;
        CreditoAutomotriz = 500000;
        Axel = 750000;
        Roxana = 900000;
    }

    public int getCreditoHipotecario()
    {
        return CreditoHipotecario;
    }

    public int getCreditoAutomotriz()
    {
        return CreditoAutomotriz;
    }

    public int getAxel()
    {
        return Axel;
    }

    public int getRoxana()
    {
        return Roxana;
    }

    public void setCreditoHipotecario(int creditoHipotecario)
    {
        CreditoHipotecario = creditoHipotecario;
    }

    public void setCreditoAutomotriz(int creditoAutomotriz)
    {
        CreditoAutomotriz = creditoAutomotriz;
    }

    public void setAxel(int axel)
    {
        Axel = axel;
    }

    public void setRoxana(int roxana)
    {
        Roxana = roxana;
    }
}

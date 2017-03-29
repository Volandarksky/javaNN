package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.System;

/**
 * Created by Кифа ^^ on 29.03.2017.
 * Определяет, идти Васе сегодня гулять или нет
 * Вася идет гулять, если на улице нет дождя, тепло и дует ветер
 */
public class Weather  {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Программа определяет пойдет сегодня гулять Вася или нет.");
        System.out.println();
        System.out.println("Введите значения");
        System.out.println();

        System.out.println("Осадки: 1(да) 0(нет)");
        String input_precipitation = reader.readLine();

        System.out.println("Температура: 1(тепло) 0(холодно)");
        String input_temperature = reader.readLine();

        System.out.println("Ветер: 1(да) 0(нет)");
        String input_wind = reader.readLine();

        double precipitation = Double.parseDouble(input_precipitation);
        double temperature = Double.parseDouble(input_temperature);
        double wind = Double.parseDouble(input_wind);

        System.out.println();
        System.out.println(activation_function(precipitation, temperature, wind));
    }
    public static String activation_function (double a, double b, double c){

        double x = predict(a,b,c);
        String yes = "Вася идет гулять";
        String no = "Вася не идет гулять";

        if (x>=0.5)
            return yes;
        else
            return no;
    }
    public static double predict (double precipitation1, double temperature1, double wind1){

        double inputs [] = {precipitation1, temperature1, wind1};
        double [] weights_to_neuron = {0.3, 0.3, 0.3}; // веса вх. сигналов
        double output_result = 0;

        for (int i=0; i<3; i++){
            double n = inputs[i]*weights_to_neuron[i];
            output_result = output_result + n;
        }
        return output_result;
    }
}

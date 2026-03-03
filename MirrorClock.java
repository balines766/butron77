public class MirrorClock {
    // Recibe una cadena "HH:MM" y devuelve la hora espejo en formato "HH:MM"
    public static String mirrorTime(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        hour = hour % 12;
        if (hour == 0) hour = 12;

        int mh, mm;
        if (minute == 0) {
            mh = (12 - hour) % 12;
            if (mh == 0) mh = 12;
            mm = 0;
        } else {
            mh = 11 - hour;
            while (mh <= 0) mh += 12;
            mm = 60 - minute;
        }

        return String.format("%02d:%02d", mh, mm);
    }

    public static void main(String[] args) throws Exception {
        String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            System.out.print("Ingrese hora (HH:MM): ");
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            input = br.readLine().trim();
        }

        if (!input.matches("\\\
\d{1,2}:\d{2}")) {
            System.err.println("Formato inválido. Use HH:MM");
            System.exit(1);
        }

        System.out.println(mirrorTime(input));
    }
}

fun main() {
    var (ves_splava, ves_zagotovki, ves_detali) = readLine()!!.split(" ").map { it.toInt() }
    // 10 5 2
    if (ves_zagotovki < ves_detali) {
        println(0)
    } else {
        var zagotovok: Int
        var detaley: Int

        var ostatok_splava: Int
        var ostatok_zagotovok: Int
        
        var ans = 0

        while (ves_splava >= ves_zagotovki) {
            zagotovok = (ves_splava / ves_zagotovki).toInt()
            // 10/5 = 2
            // 200/1 = 200
            detaley = (ves_zagotovki / ves_detali).toInt() * zagotovok // test "200 1 2" TIME LIMIT
            // 5/2.toInt() * 2 = 4
            // 1/2.toInt() * 200 = 0

            ostatok_splava = ves_splava - ves_zagotovki * zagotovok
            // 10 - 5*2 = 0
            ostatok_zagotovok = ves_zagotovki * zagotovok - ves_detali * detaley
            // 5*2 - 2*4 = 2

            ans += detaley
            // 4
            ves_splava = ostatok_splava + ostatok_zagotovok
            // 0 + 2 = 2
        }
        
        println(ans)
    }
}
impl Solution {
    pub fn min_steps(n: i32) -> i32 {
        if n == 1 {
            return 0;
        }
        let divisor = Self::gcd(n);
        return Self::min_steps(divisor) + n / divisor;
    }

    pub fn gcd(n: i32) -> i32 {
        for i in 2..=n / 2 {
            if n % i == 0 {
                return n / i;
            }
        }
        return 1;
    }
}
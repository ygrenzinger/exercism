extern crate chrono;
use chrono::*;


// Returns a UTC DateTime one billion seconds after start.
pub fn after(start: DateTime<UTC>) -> DateTime<UTC> {
    let v: i64 = 10i64.pow(9);
    let gigasecond = Duration::seconds(v);
    start + gigasecond
}

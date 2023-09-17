import { useState } from 'react';
import './Counter.css';

export default function Counter() {
    // const state = useState(0);
    // 구조 분해
    // current value, function(for update)
    // useStatue(initial value);
    const [count, setCount] = useState(0);

    function incrementCounterFunction() {
        // state[1](state[0] + 1);
        // console.log(state[0]);
        // console.log(state[1]);
        setCount(count + 1);
        // console.log(count);
    }

    return (
        <div className="Counter">
            <span className="count">{count}</span>
            <div>
                <button className="counterButton" 
                        onClick={incrementCounterFunction}
                        >+1</button>
            </div>
        </div>
    )
}

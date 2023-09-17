import { useState } from 'react';
import { PropTypes } from 'prop-types'
import './Counter.css';

export default function Counter({by}) {
    // 구조 분해
    // current value, function(for update)
    // useStatue(initial value);
    const [count, setCount] = useState(0);

    console.log(by)

    function incrementCounterFunction() {
        setCount(count + by);
    }

    function decrementCounterFunction() {
        setCount(count - by);
    }

    return (
        <div className="Counter">
            <span className="count">{count}</span>
            <div>
                <button className="counterButton" 
                        onClick={incrementCounterFunction}
                        >+{by}</button>
                <button className="counterButton"
                        onClick={decrementCounterFunction}
                        >-{by}</button>
            </div>
        </div>
    )
}

Counter.protTypes = {
    // 타입이 맞지 않으면 타입 오류 출력
    by: PropTypes.number
}

Counter.defaultProps = {
    by: 1
}
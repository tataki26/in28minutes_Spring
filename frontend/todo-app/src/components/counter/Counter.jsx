import { useState } from 'react';
import { PropTypes } from 'prop-types'
import './Counter.css';

export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(count + by)
    }

    return (
        <>
            <span className="totalCount">{count}</span>
            <CounterButton />
            <CounterButton by={2}/>
            <CounterButton by={5}/>
        </>
    )
}

function CounterButton({by}) {
    const [count, setCount] = useState(0);

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

CounterButton.protTypes = {
    // 타입이 맞지 않으면 타입 오류 출력
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 1
}
import { PropTypes } from 'prop-types'

export default function CounterButton({by, incrementMethod, decrementMethod}) {
    return (
        <div className="Counter">
            <div>
                <button className="counterButton" 
                        onClick={() => incrementMethod(by)}
                        >+{by}</button>
                <button className="counterButton"
                        onClick={() => decrementMethod(by)}
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
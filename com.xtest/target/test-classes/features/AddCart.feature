Feature: login functionality

@reg @smok
Scenario Outline: verify sucsessful login with correct username and password
When user enter correct "<username>" and "<password>"
And user click on login button
Then validate sucessful login

Examples:
| username | password |
| standard_user  | secret_sauce |

@reg 
Scenario Outline: verify sucsessful login with incorrect username and password
When user enter incorrect "< username>" and "<password>"
And user click on login button
Then validate error message

Examples:
| username | password |
| shrad    | secret_sauce |
| shra22d | s0220test |

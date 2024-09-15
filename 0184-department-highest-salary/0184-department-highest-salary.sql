# Write your MySQL query statement below
select
    d.name as Department,
    e.name as Employee,
    e.salary as Salary
from
    department d
join
    employee e on d.id = e.departmentId
where
    (e.departmentId, e.salary) in (
        select
            departmentId,
            max(salary)
        from
            employee
        group by
            departmentId
    );